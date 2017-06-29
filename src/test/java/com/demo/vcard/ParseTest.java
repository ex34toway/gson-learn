package com.demo.vcard;

import ezvcard.Ezvcard;
import ezvcard.VCard;
import ezvcard.property.Telephone;
import org.junit.Test;

import java.util.List;

/**
 * Created by liliang on 2017/6/29.
 */
public class ParseTest
{
    private final static String vcardStr = "BEGIN:VCARD\n" +
            "VERSION:2.1\n" +
            "N;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:=E6=9D=8E;=E6=97=BA;=E8=BF=9C;;\n" +
            "FN;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:=E6=9D=8E=E8=BF=9C=E6=97=BA\n" +
            "TEL;CELL;PREF:073-465-23846\n" +
            "END:VCARD";

    @Test
    public void baseTest()
    {
        System.out.println(Ezvcard.parse(vcardStr).first().writeJson());
//        String fullName = vcard.getFormattedName().getValue();
//        List<Telephone> telephoneList = vcard.getTelephoneNumbers();
//        for(Telephone telephone : telephoneList){
//            System.out.println(telephone.getText());
//        }
    }
}
