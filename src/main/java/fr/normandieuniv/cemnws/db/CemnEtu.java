package fr.normandieuniv.cemnws.db;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.TypedQuery;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooDbManaged(automaticallyDelete = true)
@RooJpaActiveRecord(versionField = "", table = "V_NORMANDIE_LEOCARTE_ETU", schema = "APOGEE", finders = { "findCemnEtusByAnneeUniEquals", "findCemnEtusByAnneeUniEqualsAndCodEtuEquals", "findCemnEtusByAnneeUniEqualsAndNomSurCarteLike", "findCemnEtusByAnneeUniEqualsAndCodEtuEqualsAndNomSurCarteLike", "findCemnEtusByAnneeUniEqualsAndCodEtuEqualsOrAnneeUniEqualsAndNomSurCarteLike" })
public class CemnEtu {

    @Id
    @Column(name = "COD_ETU")
    private BigDecimal codEtu;

    @Column(name = "REF_NU", columnDefinition = "char")
    private String refNu;

    @Column(name = "PERSID", columnDefinition = "char")
    private String persid;

    @Column(name = "EMAIL_ETAB")
    private String emailEtab;

    public static TypedQuery<fr.normandieuniv.cemnws.db.CemnEtu> findCemnEtusByAnneeUniEqualsAndCodEtuEqualsAndNomSurCarteLike(String anneeUni, BigDecimal codEtu, String nomSurCarte) {
        if (anneeUni == null || anneeUni.length() == 0) throw new IllegalArgumentException("The anneeUni argument is required");
        if (codEtu == null) throw new IllegalArgumentException("The codEtu argument is required");
        if (nomSurCarte == null || nomSurCarte.length() == 0) throw new IllegalArgumentException("The nomSurCarte argument is required");
        nomSurCarte = nomSurCarte.replace('*', '%');
        EntityManager em = CemnEtu.entityManager();
        TypedQuery<CemnEtu> q = em.createQuery("SELECT o FROM CemnEtu AS o WHERE o.anneeUni = :anneeUni  AND o.codEtu = :codEtu  AND LOWER(o.nomSurCarte) LIKE LOWER(:nomSurCarte)", CemnEtu.class);
        q.setParameter("anneeUni", anneeUni);
        q.setParameter("codEtu", codEtu);
        q.setParameter("nomSurCarte", nomSurCarte);
        return q;
    }

    public static TypedQuery<fr.normandieuniv.cemnws.db.CemnEtu> findCemnEtusByAnneeUniEqualsAndNomSurCarteLike(String anneeUni, String nomSurCarte) {
        if (anneeUni == null || anneeUni.length() == 0) throw new IllegalArgumentException("The anneeUni argument is required");
        if (nomSurCarte == null || nomSurCarte.length() == 0) throw new IllegalArgumentException("The nomSurCarte argument is required");
        nomSurCarte = nomSurCarte.replace('*', '%');
        EntityManager em = CemnEtu.entityManager();
        TypedQuery<CemnEtu> q = em.createQuery("SELECT o FROM CemnEtu AS o WHERE o.anneeUni = :anneeUni  AND LOWER(o.nomSurCarte) LIKE LOWER(:nomSurCarte)", CemnEtu.class);
        q.setParameter("anneeUni", anneeUni);
        q.setParameter("nomSurCarte", nomSurCarte);
        return q;
    }

    public static TypedQuery<fr.normandieuniv.cemnws.db.CemnEtu> findCemnEtusByAnneeUniEqualsAndCodEtuEqualsOrAnneeUniEqualsAndNomSurCarteLike(String anneeUni, BigDecimal codEtu, String nomSurCarte) {
        if (anneeUni == null || anneeUni.length() == 0) throw new IllegalArgumentException("The anneeUni argument is required");
        if (codEtu == null) throw new IllegalArgumentException("The codEtu argument is required");
        if (anneeUni == null || anneeUni.length() == 0) throw new IllegalArgumentException("The anneeUni argument is required");
        if (nomSurCarte == null || nomSurCarte.length() == 0) throw new IllegalArgumentException("The nomSurCarte argument is required");
        nomSurCarte = nomSurCarte.replace('*', '%');
        EntityManager em = entityManager();
        TypedQuery<CemnEtu> q = em.createQuery("SELECT o FROM CemnEtu AS o WHERE o.anneeUni = :anneeUni  AND o.codEtu = :codEtu  OR o.anneeUni = :anneeUni  AND LOWER(o.nomSurCarte) LIKE LOWER(:nomSurCarte)", CemnEtu.class);
        q.setParameter("anneeUni", anneeUni);
        q.setParameter("codEtu", codEtu);
        q.setParameter("anneeUni", anneeUni);
        q.setParameter("nomSurCarte", nomSurCarte);
        return q;
    }

    public static TypedQuery<fr.normandieuniv.cemnws.db.CemnEtu> findCemnEtusByAnneeUniEqualsAndCodEtuEqualsOrAnneeUniEqualsAndNomSurCarteLike(String anneeUni, BigDecimal codEtu, String bidon, String nomSurCarte) {
        return findCemnEtusByAnneeUniEqualsAndCodEtuEqualsOrAnneeUniEqualsAndNomSurCarteLike(anneeUni, codEtu, nomSurCarte);
    }
}
