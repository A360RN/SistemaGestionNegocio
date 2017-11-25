/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import pe.com.sunshineandina.dto.ClienteTO;
import pe.com.sunshineandina.dto.HistoricoDistribuidorTO;

/**
 *
 * @author alonsorn
 * Colocar en el nombre del metodo el mismo nombre
 * que el response que se esta mapeando
 */
public class ResponseMapper {
    
    public JsonNode ventasDistribuidorMapper(List<HistoricoDistribuidorTO> lstVentas, List<ClienteTO> lstDistribuidores){
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonRespuesta = mapper.createObjectNode();
        
        
        return jsonRespuesta;
    }
}
