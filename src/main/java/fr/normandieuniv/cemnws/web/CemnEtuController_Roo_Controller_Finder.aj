// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.normandieuniv.cemnws.web;

import fr.normandieuniv.cemnws.db.CemnEtu;
import fr.normandieuniv.cemnws.web.CemnEtuController;
import java.math.BigDecimal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

privileged aspect CemnEtuController_Roo_Controller_Finder {
    
    @RequestMapping(params = { "find=ByAnneeUniEquals", "form" }, method = RequestMethod.GET)
    public String CemnEtuController.findCemnEtusByAnneeUniEqualsForm(Model uiModel) {
        return "cemnetus/findCemnEtusByAnneeUniEquals";
    }
    
    @RequestMapping(params = "find=ByAnneeUniEquals", method = RequestMethod.GET)
    public String CemnEtuController.findCemnEtusByAnneeUniEquals(@RequestParam("anneeUni") String anneeUni, Model uiModel) {
        uiModel.addAttribute("cemnetus", CemnEtu.findCemnEtusByAnneeUniEquals(anneeUni).getResultList());
        return "cemnetus/list";
    }
    
    @RequestMapping(params = { "find=ByAnneeUniEqualsAndCodEtuEquals", "form" }, method = RequestMethod.GET)
    public String CemnEtuController.findCemnEtusByAnneeUniEqualsAndCodEtuEqualsForm(Model uiModel) {
        return "cemnetus/findCemnEtusByAnneeUniEqualsAndCodEtuEquals";
    }
    
    @RequestMapping(params = "find=ByAnneeUniEqualsAndCodEtuEquals", method = RequestMethod.GET)
    public String CemnEtuController.findCemnEtusByAnneeUniEqualsAndCodEtuEquals(@RequestParam("anneeUni") String anneeUni, @RequestParam("codEtu") BigDecimal codEtu, Model uiModel) {
        uiModel.addAttribute("cemnetus", CemnEtu.findCemnEtusByAnneeUniEqualsAndCodEtuEquals(anneeUni, codEtu).getResultList());
        return "cemnetus/list";
    }
    
    @RequestMapping(params = { "find=ByAnneeUniEqualsAndCodEtuEqualsAndNomSurCarteLike", "form" }, method = RequestMethod.GET)
    public String CemnEtuController.findCemnEtusByAnneeUniEqualsAndCodEtuEqualsAndNomSurCarteLikeForm(Model uiModel) {
        return "cemnetus/findCemnEtusByAnneeUniEqualsAndCodEtuEqualsAndNomSurCarteLike";
    }
    
    @RequestMapping(params = "find=ByAnneeUniEqualsAndCodEtuEqualsAndNomSurCarteLike", method = RequestMethod.GET)
    public String CemnEtuController.findCemnEtusByAnneeUniEqualsAndCodEtuEqualsAndNomSurCarteLike(@RequestParam("anneeUni") String anneeUni, @RequestParam("codEtu") BigDecimal codEtu, @RequestParam("nomSurCarte") String nomSurCarte, Model uiModel) {
        uiModel.addAttribute("cemnetus", CemnEtu.findCemnEtusByAnneeUniEqualsAndCodEtuEqualsAndNomSurCarteLike(anneeUni, codEtu, nomSurCarte).getResultList());
        return "cemnetus/list";
    }
    
    @RequestMapping(params = { "find=ByAnneeUniEqualsAndCodEtuEqualsOrAnneeUniEqualsAndNomSurCarteLike", "form" }, method = RequestMethod.GET)
    public String CemnEtuController.findCemnEtusByAnneeUniEqualsAndCodEtuEqualsOrAnneeUniEqualsAndNomSurCarteLikeForm(Model uiModel) {
        return "cemnetus/findCemnEtusByAnneeUniEqualsAndCodEtuEqualsOrAnneeUniEqualsAndNomSurCarteLike";
    }
    
    @RequestMapping(params = "find=ByAnneeUniEqualsAndCodEtuEqualsOrAnneeUniEqualsAndNomSurCarteLike", method = RequestMethod.GET)
    public String CemnEtuController.findCemnEtusByAnneeUniEqualsAndCodEtuEqualsOrAnneeUniEqualsAndNomSurCarteLike(@RequestParam("anneeUni") String anneeUni, @RequestParam("codEtu") BigDecimal codEtu, @RequestParam("nomSurCarte") String nomSurCarte, Model uiModel) {
        uiModel.addAttribute("cemnetus", CemnEtu.findCemnEtusByAnneeUniEqualsAndCodEtuEqualsOrAnneeUniEqualsAndNomSurCarteLike(anneeUni, codEtu, nomSurCarte).getResultList());
        return "cemnetus/list";
    }
    
    @RequestMapping(params = { "find=ByAnneeUniEqualsAndNomSurCarteLike", "form" }, method = RequestMethod.GET)
    public String CemnEtuController.findCemnEtusByAnneeUniEqualsAndNomSurCarteLikeForm(Model uiModel) {
        return "cemnetus/findCemnEtusByAnneeUniEqualsAndNomSurCarteLike";
    }
    
    @RequestMapping(params = "find=ByAnneeUniEqualsAndNomSurCarteLike", method = RequestMethod.GET)
    public String CemnEtuController.findCemnEtusByAnneeUniEqualsAndNomSurCarteLike(@RequestParam("anneeUni") String anneeUni, @RequestParam("nomSurCarte") String nomSurCarte, Model uiModel) {
        uiModel.addAttribute("cemnetus", CemnEtu.findCemnEtusByAnneeUniEqualsAndNomSurCarteLike(anneeUni, nomSurCarte).getResultList());
        return "cemnetus/list";
    }
    
}
