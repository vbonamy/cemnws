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
// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.normandieuniv.cemnws.db;

import fr.normandieuniv.cemnws.db.CemnEtu;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect CemnEtu_Roo_Finder {
    
    public static TypedQuery<CemnEtu> CemnEtu.findCemnEtusByAnneeUniEquals(String anneeUni) {
        if (anneeUni == null || anneeUni.length() == 0) throw new IllegalArgumentException("The anneeUni argument is required");
        EntityManager em = CemnEtu.entityManager();
        TypedQuery<CemnEtu> q = em.createQuery("SELECT o FROM CemnEtu AS o WHERE o.anneeUni = :anneeUni", CemnEtu.class);
        q.setParameter("anneeUni", anneeUni);
        return q;
    }
    
    public static TypedQuery<CemnEtu> CemnEtu.findCemnEtusByAnneeUniEqualsAndCodEtuEquals(String anneeUni, BigDecimal codEtu) {
        if (anneeUni == null || anneeUni.length() == 0) throw new IllegalArgumentException("The anneeUni argument is required");
        if (codEtu == null) throw new IllegalArgumentException("The codEtu argument is required");
        EntityManager em = CemnEtu.entityManager();
        TypedQuery<CemnEtu> q = em.createQuery("SELECT o FROM CemnEtu AS o WHERE o.anneeUni = :anneeUni  AND o.codEtu = :codEtu", CemnEtu.class);
        q.setParameter("anneeUni", anneeUni);
        q.setParameter("codEtu", codEtu);
        return q;
    }
    
}