/**
 * Licensed to Universite de Rouen under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 *
 * Universite de Rouen licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
@RooJpaActiveRecord(versionField = "", table = "CEMN_ETU", schema = "APOGEE", finders = { "findCemnEtusByAnneeUniEquals", "findCemnEtusByAnneeUniEqualsAndCodEtuEquals", "findCemnEtusByAnneeUniEqualsAndNomSurCarteLike", "findCemnEtusByAnneeUniEqualsAndCodEtuEqualsAndNomSurCarteLike", "findCemnEtusByAnneeUniEqualsAndCodEtuEqualsOrAnneeUniEqualsAndNomSurCarteLike" }, identifierColumn="COD_ETU")
public class CemnEtu {

    @Id
    @Column(name = "COD_ETU")
    private BigDecimal codEtu;
    
    @Column(name = "REF_NU", columnDefinition = "char")
    private String refNu;
      
    @Column(name = "PERSID")
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
