package Utils;

import org.junit.Assert;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class EncryptUtilTest extends ApplicationTest {

    @Test
    public void testEncrypt()
    {
        String password = "parola";
        String encrypted = EncryptUtil.encrypt(password);
        boolean areEquals=true;
        if(!password.equals(encrypted)) //daca nu sunt egale, falses
            areEquals=false;
        Assert.assertEquals(false,areEquals);
    }

    @Test
    public void testDecrypt()
    {
        String cryptedPassword="1PnM2h/rtOd9iz0/A/nZBw==";
        String decrypted = EncryptUtil.decrypt(cryptedPassword);
        boolean areEquals = true;
        if(!cryptedPassword.equals(decrypted))
            areEquals=false;
        Assert.assertEquals(false,areEquals);
    }

}
