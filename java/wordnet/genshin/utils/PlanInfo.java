package wordnet.genshin.utils;

public class PlanInfo {
    private Integer Sum;
    private String BookName;
    private Integer Learned;
    private Integer Goal;
    private Image image; // 包含图像信息的 Image 对象

    public PlanInfo() {}

    public PlanInfo(Integer Sum, String BookName, Integer Learned, Integer Goal, Image image) {
        this.Sum = Sum;
        this.BookName = BookName;
        this.Learned = Learned;
        this.Goal = Goal;
        this.image = image;
    }

    public Integer getSum() {
        return Sum;
    }

    public void setSum(Integer Sum) {
        this.Sum = Sum;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public Integer getLearned() {
        return Learned;
    }

    public void setLearned(Integer Learned) {
        this.Learned = Learned;
    }

    public Integer getGoal() {
        return Goal;
    }

    public void setGoal(Integer Goal) {
        this.Goal = Goal;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "PlanInfo{" +
                "Sum=" + Sum +
                ", BookName='" + BookName + '\'' +
                ", Learned=" + Learned +
                ", Goal=" + Goal +
                ", Image=" + image +
                '}';
    }
}

