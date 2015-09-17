package ru.maxsut.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.maxsut.domain.Disc;
import ru.maxsut.domain.User;
import ru.maxsut.service.CustomService;

import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("file-manager/")
@SessionAttributes("sessionUserName")
public class FileManagerController {

    private final Long MAX_USER_IMG_SIZE = 65500L;
    private final Long MAX_DISC_IMG_SIZE = 2000000L;
    private final String MESSAGE = "данный файл не может быть выбран из за неправильного разрешения, либо из за слишком большого размера!";

    @Autowired
    CustomService service;

    @RequestMapping(value = "/uploadPhoto/{entity}/{name}", method = RequestMethod.POST)
    public String uploadPhoto( @ModelAttribute("sessionUserName") String userName,
                               @PathVariable String entity,
                               @PathVariable String name,
                               Model model,
                               @RequestParam(value = "photoFile", required = false) MultipartFile photoFile) throws IOException
    {
        String message = "";

        if (isCorrectFileExt(photoFile) && isCorrectFileSize(entity, photoFile)) {
            InputStream inputStream = photoFile.getInputStream();
            byte[] fileContent = IOUtils.toByteArray(inputStream);

            if (entity.equals("user")){

                User user = service.findUserByName(userName);
                user.setPhoto(fileContent);
                service.updateUser(user);

                return "redirect:/profile/user/";
            } else {

                Disc disc = service.findDiscByTitle(name);
                disc.setImgDisc(fileContent);
                service.updateDisc(disc);

                return "redirect:/discManager/edit-" + disc.getId() + "-disc";
            }

        } else {
            message += MESSAGE;
            model.addAttribute("message", message);
            return "/profile/error";
        }
    }

    @RequestMapping(value = "/photo/{entity}/{nameItem}", method = RequestMethod.GET)
    @ResponseBody
    public byte[] downloadPhoto(@PathVariable String entity, @PathVariable String nameItem){

        if (entity.equals("user")){
            User user = service.findUserByName(nameItem);
            return user.getPhoto();
        } else {
            Disc disc = service.findDiscByTitle(nameItem);
            return disc.getImgDisc();
        }
    }

    private String getFileExt(MultipartFile file){

        String fileName = file.getOriginalFilename();
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    private boolean isCorrectFileExt(MultipartFile file){

        String exts[] = {"png", "jpg", "jpeg", "gif"};
        for (String ext : exts) {
            if(getFileExt(file).equals(ext))
                return true;
        }
        return false;
    }

    private boolean isCorrectFileSize(String entityName, MultipartFile file) {

        Long fileSize = file.getSize();
        if (entityName.equals("user")){
            if (fileSize <= MAX_USER_IMG_SIZE)
                return true;
            return false;
        } else {
            if (fileSize <= MAX_DISC_IMG_SIZE)
                return true;
            return false;
        }
    }
}
