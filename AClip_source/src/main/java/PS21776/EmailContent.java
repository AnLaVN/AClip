package PS21776;

public class EmailContent {
	private static final String contentOTP = "<body style=\"min-height: 100vh; width: 100%; margin: 0 auto;\r\n"
			+ "background-image: linear-gradient(to right top, #d16ba5, #c777b9, #ba83ca, #aa8fd8, #9a9ae1, #8aa7ec, #79b3f4, #69bff8, #52cffe, #41dfff, #46eefa, #5ffbf1);\r\n"
			+ "background-repeat: no-repeat;\">\r\n"
			+ "	<div style=\"font-family: Helvetica,Arial,sans-serif;overflow:auto;line-height:2;text-align:center;padding: 0.2em;\">\r\n"
			+ "		<img src=\"https://cdn-icons-png.flaticon.com/512/5510/5510342.png\" style=\"height: 25%; max-height: 250px; margin: 20px auto;\">\r\n"
			+ "		<div style=\"border-bottom:2px solid rgb(215, 215, 215)\">\r\n"
			+ "			<a href=\"\" style=\"font-size:1.4em;color: #0f4058;text-decoration:none;font-weight:600\">AClip - ASM Java4</a>\r\n"
			+ "		</div>\r\n"
			+ "		<p style=\"font-size:1.1em\">Hi, USERNAME</p>\r\n"
			+ "		<p>\r\n"
			+ "			&#272;&#227; c&#243; y&#234;u c&#7847;u thay &#273;&#7893;i m&#7853;t kh&#7849;u c&#7911;a b&#7841;n! <br>\r\n"
			+ "			N&#7871;u &#273;&#7845;y kh&#244;ng ph&#7843;i l&#224; b&#7841;n, vui l&#242;ng b&#7887; qua email n&#224;y. <br><br>\r\n"
			+ "			N&#7871;u b&#7841;n ti&#7871;p t&#7909;c &#273;&#432;&#7907;c y&#234;u c&#7847;u &#273;&#7893;i m&#7853;t kh&#7849;u. <br>\r\n"
			+ "			T&#7913;c l&#224; ai &#273;&#243; &#273;ang c&#7889; x&#226;m nh&#7853;p v&#224;o t&#224;i kho&#7843;n c&#7911;a b&#7841;n.\r\n"
			+ "		</p>\r\n"
			+ "		<h2 style=\"background: #00466a;margin: 0 auto;width: max-content; padding: 0 10px;color: #fff;border-radius: 4px;\">123456</h2><br>\r\n"
			+ "		<i style=\"font-size:1em;\">Kh&#244;ng chia s&#7867; m&#227; n&#224;y cho b&#7845;t k&#236; ai !</i>\r\n"
			+ "		<hr style=\"border:none;border-top:2px solid rgb(215, 215, 215)\"/>\r\n"
			+ "		<p style=\"font-size:0.9em;\">Tr&#226;n tr&#7885;ng, by AnLaVN</p>\r\n"
			+ "	</div>\r\n"
			+ "</body>";
	private static final String contentShare = "<body style=\"min-height: 100vh; width: 100%; margin: 0 auto;\r\n"
			+ "background-image: linear-gradient(to right top, #d16ba5, #c777b9, #ba83ca, #aa8fd8, #9a9ae1, #8aa7ec, #79b3f4, #69bff8, #52cffe, #41dfff, #46eefa, #5ffbf1);\r\n"
			+ "background-repeat: no-repeat;\">\r\n"
			+ "	<div style=\"font-family: Helvetica,Arial,sans-serif;overflow:auto;line-height:2;text-align:center;padding: 0.2em;\">\r\n"
			+ "		<img src=\"https://cdn-icons-png.flaticon.com/512/5510/5510342.png\" style=\"height: 25%; max-height: 250px; margin: 20px auto;\">\r\n"
			+ "		<div style=\"border-bottom:2px solid rgb(215, 215, 215)\">\r\n"
			+ "			<a href=\"\" style=\"font-size:1.4em;color: #0f4058;text-decoration:none;font-weight:600\">AClip - ASM Java4</a>\r\n"
			+ "		</div>\r\n"
			+ "		<p style=\"font-size:1.1em\">N&#7897;i dung chia s&#7867;</p>\r\n"
			+ "		<p>\r\n"
			+ "			USERNAME v&#7915;a chia s&#7867; m&#7897;t video &#273;&#7871;n b&#7841;n. <br>\r\n"
			+ "			Truy c&#7853;p li&#234;n k&#7871;t sau &#273;&#7875; t&#236;m hi&#7875;u th&#234;m.\r\n"
			+ "		</p>\r\n"
			+ "		<i style=\"font-size:1em;\">LINK</i>\r\n"
			+ "		<hr style=\"border:none;border-top:2px solid rgb(215, 215, 215)\"/>\r\n"
			+ "		<p style=\"font-size:0.9em;\">Tr&#226;n tr&#7885;ng, by AnLaVN</p>\r\n"
			+ "	</div>\r\n"
			+ "</body>";
	
	private static final String getUnicode(String username) {
		String usernameUnicode = "";
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i); int value = c;
            usernameUnicode += "&#" + value + ";";
        }
        return usernameUnicode;
	}
	
	
	public static final String getOTP(String username, String otp) {
		return contentOTP.replaceFirst("USERNAME", getUnicode(username)).replaceFirst("123456", otp);
	}
	
	
	public static String getShare(String username, String link) {
		return contentShare.replaceFirst("USERNAME", getUnicode(username)).replaceFirst("LINK", link);
	}
}