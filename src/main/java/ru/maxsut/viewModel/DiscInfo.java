package ru.maxsut.viewModel;

import ru.maxsut.domain.Disc;

import java.util.List;

/**
 * Created by �������� on 27.07.2015.
 */
public class DiscInfo {

    private String name;
    private int ownDiscAmount;
    private int hiredDiscAmount;
    private List<Disc> discs;

    public int getOwnDiscAmount() {
        return ownDiscAmount;
    }

    public void setOwnDiscAmount(int ownDiscAmount) {
        this.ownDiscAmount = ownDiscAmount;
    }

    public int getHiredDiscAmount() {
        return hiredDiscAmount;
    }

    public void setHiredDiscAmount(int hiredDiscAmount) {
        this.hiredDiscAmount = hiredDiscAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Disc> getDiscs() {
        return discs;
    }

    public void setDiscs(List<Disc> discs) {
        this.discs = discs;
    }
}
