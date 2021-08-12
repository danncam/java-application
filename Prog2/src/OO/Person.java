package OO;

/*
 *  March 20
 */
public class Person 
{

    private String name, address, phone, age, cpf, rg;

    public void setAllAttributes(String name, String address, String phone, String cpf, String rg, String age)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.cpf = cpf;
        this.rg = rg;
        this.age = age;
        
    }


    public void setAddress(String address) 
    {
        this.address = address;
    }
    
    public void setPhone(String phone) 
    {
        if(phone.length() == 8)
            this.phone = phone;
        else
            System.out.println("Número de telefone inválido: diferente de 8 digitos");
    }
    public void setAge(String age) 
    {
        if ((Byte.parseByte(age) < 127) || (Byte.parseByte(age) > 0))
            this.age = age;
        else
            System.out.println("Idade inválida: maior que 127 ou menor que 0");
    }

    public void setCpf(String cpf) 
    {
        if (cpf.length() == 11)
            this.cpf = cpf;
        else
            System.out.println("CPF inválido: não possui todos os dígitos");
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setRg(String rg) 
    {
        this.rg = rg;
    }

    public String getName() 
    {
        return name;
    }

    public String getAddress() 
    {
        return address;
    }
    public String getPhone()
    {
        
        return phone;
    }
    public String getAge() 
    {
        return age;
    }

    public String getCpf() 
    {
        return cpf;
    }

    public String getRg() 
    {
        return rg;
    }


}
