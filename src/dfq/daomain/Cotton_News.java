package dfq.daomain;

public class Cotton_News {
    private String province;
    private String city;
    private String town;
    private String village;
    private String breed;
    private String density;
    private String investigator;
    private String tabledate;
    private String xiaoqu;
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getXiaoqu() {
        return xiaoqu;
    }

    public void setXiaoqu(String xiaoqu) {
        this.xiaoqu = xiaoqu;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public String getInvestigator() {
        return investigator;
    }

    public void setInvestigator(String investigator) {
        this.investigator = investigator;
    }

    public String getTabledate() {
        return tabledate;
    }

    public void setTabledate(String tabledate) {
        this.tabledate = tabledate;
    }
    @Override
    public String toString() {
        return "Cotton_News{" +
                "id=" + id +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", town='" + town + '\'' +
                ", village='" + village + '\'' +
                ", breed='" + breed + '\'' +
                ", density='" + density + '\'' +
                ", investigator='" + investigator + '\'' +
                ", tabledate='" + tabledate + '\'' +
                ", xiaoqu='" + xiaoqu + '\'' +
                '}';
    }
}
