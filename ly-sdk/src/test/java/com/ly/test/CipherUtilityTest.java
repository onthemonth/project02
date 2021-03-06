package com.ly.test;

import org.junit.Assert;
import org.junit.Test;

import com.ly.sdk.patools.PaAesTools;
import com.ly.sdk.utils.CipherUtility;

public class CipherUtilityTest {

    @Test
    public void encryTest() {
        //CipherUtility test = new CipherUtility();
        //加密时 请确认env下有key为private的属性
        // System.out.println(CipherUtility.AES.encrypt("jdbc:mysql://127.0.0.1:3306/ly_sms?characterEncoding=UTF-8"));
        Assert.assertEquals(CipherUtility.AES.encrypt("leyaftpadmin"), "cyl2JQSTUj5d-P_eWUINMQ");
        Assert.assertEquals(CipherUtility.AES.encrypt("leyatestftp"), "s5FgCWJkjhtlkZPpWTMNKA");
        //Assert.assertEquals(CipherUtility.AES.encrypt("leyatestftp"),"error");
    }

    /**
     * 
     * <p>
     * Description: 测试平安加解密
     * </p>
     */
    @Test
    public void paEncryTest() {
        String str = "abc";
        String paStr = "9TGDf5G+OOIxyX2wEDkjMQ==";
        // System.out.println(decryptString("9TGDf5G+OOIxyX2wEDkjMQ=="));
        Assert.assertEquals(PaAesTools.encryptString(str), paStr);
        
        String preStr = "当然，它表示参数是另一个页面提交过来的";
		/*String gbkByte = new String(preStr.getBytes("gbk"),"GBK");
		System.out.println(gbkByte);
		
		System.out.println(new String(gbkByte.getBytes("UTF-8"),"UTF-8"));*/
		String encryData = PaAesTools.encryptString(preStr);
		System.out.println(encryData);
		System.out.println(PaAesTools.decryptString(encryData));
    }
    


    @Test
    public void uatDatabaseData(){
        String userName = "utest";
        String password = "cow8(*3dlFAQ";
        String encryUserName = CipherUtility.AES.encrypt(userName);
        String encryPwd = CipherUtility.AES.encrypt(password);
        System.out.println(encryUserName);
        System.out.println(encryPwd);

        
        System.out.println(CipherUtility.AES.decrypt(encryUserName));
        
        System.out.println(CipherUtility.AES.decrypt(encryPwd));
    }
    
    @Test
    public void encryPaUserPwd(){
        String userName = "AI2ZDCONSH2TBPQVK3F5DRE4DTC4U9AZ1XCIFXE5QZVLE4SI";
        String password = "jt6Ss47N";
        String encryUserName = CipherUtility.AES.encrypt(userName);
        String encryPwd = CipherUtility.AES.encrypt(password);
        System.out.println(encryUserName);
        System.out.println(encryPwd);
        System.out.println(CipherUtility.AES.decrypt(encryUserName));
        
        System.out.println(CipherUtility.AES.decrypt(encryPwd));
    }

}
