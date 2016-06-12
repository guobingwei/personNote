import java.io.BufferedOutputStream

String urlString = 'http://wx.qlogo.cn/mmopen/ajNVdqHZLLAWuNf49VxgoIr6KYJiauZU0UM93XxXBUiafU3VffDuk0N6rSSZbq0J838eoEME2IlBgTqLTpaQh72g/0'

byte[] b = new URL(urlString).bytes
println b.size()

// BufferedImage img = ImageIO.read(new ByteArrayInputStream(b));

try {
    out = new BufferedOutputStream(new FileOutputStream('headimg.jpg'));
    out.write(b);
} finally {
    if (out != null) out.close();
}