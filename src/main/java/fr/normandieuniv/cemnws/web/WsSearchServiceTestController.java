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
package fr.normandieuniv.cemnws.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.normandieuniv.cemnws.db.CemnEtu;
import fr.normandieuniv.cemnws.services.CemnWsSearchService;

@RequestMapping("/searchwstest/**")
@Controller
public class WsSearchServiceTestController {

	@Resource
	CemnWsSearchService cemnWsSearchService;
    
    @RequestMapping(value="search", method = RequestMethod.GET)
    public String searchWs(@RequestParam(required=false) Integer anneeUniv, @RequestParam(required=false) String codEtu, @RequestParam(required=false) String nom, @RequestParam(required=false) Integer operator, Model uiModel) {
    	List<CemnEtu> cemnEtus = cemnWsSearchService.search(anneeUniv, codEtu, nom, operator);
        uiModel.addAttribute("cemnetus", cemnEtus);
        return "cemnetus/list";
    }
    
    @RequestMapping
    public String index() {
        return "searchwstest/index";
    }
}
