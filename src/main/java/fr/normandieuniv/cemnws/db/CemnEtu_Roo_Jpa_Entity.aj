// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.normandieuniv.cemnws.db;

import fr.normandieuniv.cemnws.db.CemnEtu;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect CemnEtu_Roo_Jpa_Entity {
    
    declare @type: CemnEtu: @Entity;
    
    declare @type: CemnEtu: @Table(schema = "APOGEE", name = "V_NORMANDIE_LEOCARTE_ETU");
    
}
