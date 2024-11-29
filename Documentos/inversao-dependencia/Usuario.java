//Fábio Massashi Suzuki 2576198
//Álefh Trindade Luz De Lima 2576147
//Gabriel Batistela da Silva 2576201

public class Usuario{
    private String user;
    private String senha;

    private AutenticadorInterface autInterface;

    public Usuario(AutenticadorInterface autInterface){
        this.autInterface = autInterface;
    }

    public int fazerLogin(String user, String senha){
        autInterface.fazerLogin(user, senha);
        return 1;
    }
}
