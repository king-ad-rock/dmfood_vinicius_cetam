package br.com.cetam.dmfood.domain.adm;

public record DadosListaAdm(
        Long id,
        String nomeAdm,
        String emailAdm
) {
    public DadosListaAdm(Adm adm) {
        this(
                adm.getId(), adm.getNomeAdm(), adm.getEmail()
        );
    }
}
