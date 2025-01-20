import control.ConexaoSQL;
import model.Equipe;

public class EquipeCtrl{
    private String liderEquipe;
    private String areaAtuacao;
    private String descricao;
    private int idEquipe;
    private String funcao;
    private ConexaoSQL conexao;

    public EquipeCtrl(){
        conexao.conectarBD();
    }

    public void adicionar(Equipe equipe){
        // implementar código
    }
}