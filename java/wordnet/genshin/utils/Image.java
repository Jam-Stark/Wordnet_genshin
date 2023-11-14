package wordnet.genshin.utils;

public class Image {
    private String fileName;
    private String base64ImageData; // 用于存储Base64编码的图像数据

    public Image() {}

    public Image(String fileName, String base64ImageData) {
        this.fileName = fileName;
        this.base64ImageData = base64ImageData;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getBase64ImageData() {
        return base64ImageData;
    }

    public void setBase64ImageData(String base64ImageData) {
        this.base64ImageData = base64ImageData;
    }
}

