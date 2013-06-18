// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.normandieuniv.cemnws.web;

import fr.normandieuniv.cemnws.db.CemnEtu;
import fr.normandieuniv.cemnws.web.CemnEtuController;
import java.math.BigDecimal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

privileged aspect CemnEtuController_Roo_Controller {
    
    @RequestMapping(value = "/{codEtu}", produces = "text/html")
    public String CemnEtuController.show(@PathVariable("codEtu") BigDecimal codEtu, Model uiModel) {
        uiModel.addAttribute("cemnetu", CemnEtu.findCemnEtu(codEtu));
        uiModel.addAttribute("itemId", codEtu);
        return "cemnetus/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String CemnEtuController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("cemnetus", CemnEtu.findCemnEtuEntries(firstResult, sizeNo));
            float nrOfPages = (float) CemnEtu.countCemnEtus() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("cemnetus", CemnEtu.findAllCemnEtus());
        }
        return "cemnetus/list";
    }
    
}
