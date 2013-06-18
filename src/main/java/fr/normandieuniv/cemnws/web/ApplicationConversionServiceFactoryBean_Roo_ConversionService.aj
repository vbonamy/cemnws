// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.normandieuniv.cemnws.web;

import fr.normandieuniv.cemnws.db.CemnEtu;
import fr.normandieuniv.cemnws.web.ApplicationConversionServiceFactoryBean;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
    
    public Converter<CemnEtu, String> ApplicationConversionServiceFactoryBean.getCemnEtuToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<fr.normandieuniv.cemnws.db.CemnEtu, java.lang.String>() {
            public String convert(CemnEtu cemnEtu) {
                return new StringBuilder().append(cemnEtu.getRefNu()).append(' ').append(cemnEtu.getPersid()).append(' ').append(cemnEtu.getEmailEtab()).toString();
            }
        };
    }
    
    public Converter<BigDecimal, CemnEtu> ApplicationConversionServiceFactoryBean.getIdToCemnEtuConverter() {
        return new org.springframework.core.convert.converter.Converter<java.math.BigDecimal, fr.normandieuniv.cemnws.db.CemnEtu>() {
            public fr.normandieuniv.cemnws.db.CemnEtu convert(java.math.BigDecimal id) {
                return CemnEtu.findCemnEtu(id);
            }
        };
    }
    
    public Converter<String, CemnEtu> ApplicationConversionServiceFactoryBean.getStringToCemnEtuConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, fr.normandieuniv.cemnws.db.CemnEtu>() {
            public fr.normandieuniv.cemnws.db.CemnEtu convert(String id) {
                return getObject().convert(getObject().convert(id, BigDecimal.class), CemnEtu.class);
            }
        };
    }
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getCemnEtuToStringConverter());
        registry.addConverter(getIdToCemnEtuConverter());
        registry.addConverter(getStringToCemnEtuConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}
