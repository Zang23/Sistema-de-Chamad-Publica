package model.entidades;

public enum AreaConhecimento {
    INFORMATICA("Informática"),
    GESTAO("Gestão"),
    ENGENHARIAS("Engenharias");

    private final String descricao;

    AreaConhecimento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static AreaConhecimento fromDescricao(String descricao) {
        for (AreaConhecimento area : AreaConhecimento.values()) {
            if (area.getDescricao().equalsIgnoreCase(descricao)) {
                return area;
            }
        }
        throw new IllegalArgumentException("Área inválida: " + descricao);
    }

}
