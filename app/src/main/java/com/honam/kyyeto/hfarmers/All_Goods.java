package com.honam.kyyeto.hfarmers;

public class All_Goods {
    private String goodsName;
    private String goodsDescription;
    private int goodsImage;

    public All_Goods(String goodsName, String goodsDescription, int goodsImage) {
        this.goodsName = goodsName;
        this.goodsDescription = goodsDescription;
        this.goodsImage = goodsImage;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public int getGoodsImage() {
        return goodsImage;
    }
}
