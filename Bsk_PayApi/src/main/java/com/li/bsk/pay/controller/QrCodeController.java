package com.li.bsk.pay.controller;

import com.li.bsk.common.util.Base64Util;
import com.li.bsk.common.util.ZxingUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
public class QrCodeController {

    @GetMapping("qrcodepay.do/{msg}")
    public void create(@PathVariable String msg, HttpServletResponse response) throws IOException {
        String m = new String (Base64Util.base64Dec (msg), StandardCharsets.UTF_8);
        BufferedImage image = ZxingUtil.createImage (m, 300, 300);
        ImageIO.write (image,"JPEG",response.getOutputStream ());
    }

    @GetMapping("qrcodecreate,do/{msg}")
    public void createQrcode(@PathVariable String msg, HttpServletResponse response) throws IOException {
        BufferedImage image = ZxingUtil.createImage (msg, 300, 300);
        ImageIO.write (image,"JPEG",response.getOutputStream ());
    }
}
