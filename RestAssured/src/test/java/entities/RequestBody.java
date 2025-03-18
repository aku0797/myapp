package entities;

public class RequestBody {
    private String email;
    private String password;
private String address;
private String name;
private int phoneNum;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     public int getPhoneNum(){
        return phoneNum;
     }
     public  String getName (){
        return  name;
     }
     public  String getAddress (){
        return address;


     }
     public void setName (String name){
        this.name=name;
     }
     public void setAddress(String address){
        this.address=address;
     }
     public void  setPhoneNum(int phoneNum){
        this.phoneNum=phoneNum;
     }


}
