package com.example.ykouta.tracking_tiger2;

import java.util.ArrayList;

/**
 * Created by Y.Kouta on 2017/11/10.
 */

//荷物データ
public class NimotuInfo  {

    String nimotuNum;       //荷物番号
    String nimotuCategory; //積載物
    String nimotuAmount;   //積載量

    public void setNimotuNum(String str) {
        this.nimotuNum = str;
    }
    public String getNimotuNum(){
        return this.nimotuNum;
    }

    public void setNimotuCategory(String str) {
        this.nimotuCategory = str;
    }
    public String getCategory(){
        return this.nimotuCategory;
    }

    public void setNimotuAmount(String str) {
        this.nimotuAmount = str;
    }
    public String getNimotuAmount(){
        return this.nimotuAmount;
    }
}
