package com.demoperson.school.serviceimpl;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demoperson.school.model.Niveau;
import com.demoperson.school.respository.NiveauRes;
import com.demoperson.school.service.NiveauService;

@Service
public class NiveauServiceImp implements NiveauService {

    @Autowired
    private NiveauRes niveauRes;
    @Override
    public ResponseEntity<List<Niveau>> getNivea() {
        // TODO Auto-generated method stub
        return new ResponseEntity<>(niveauRes.findAll(),HttpStatus.OK);
    }
    @Override
    public ResponseEntity<String> addNivea(Map<String,String>requestMap) {
        // TODO Auto-generated method stub
       try {
        Niveau niveau = new Niveau();
        niveau.setLibelle(requestMap.get("libelle"));
          niveauRes.save(niveau);

          return new ResponseEntity<>("{\"message\":\""+"Niveau bien enregistré"+"\"}",HttpStatus.OK);
       } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();


       }

       return null;
    }
    @SuppressWarnings({ "unused", "null" })
    @Override
    public ResponseEntity<String> updateNive(Map<String, String> requestMap) {
        // TODO Auto-generated method stub

        try {
            System.out.println(requestMap.get("id"));
            Optional<Niveau> niveau=niveauRes.findById(Long.parseLong(requestMap.get("id")));

            if(Objects.isNull(niveau)){
                return new ResponseEntity<>("{\"message\":\""+"Ce niveau n'excite pas"+"\"}",HttpStatus.OK);   
            }else{

                System.out.print(requestMap.get("id"));
                
                niveau.get().setLibelle(requestMap.get("libelle"));
                niveauRes.save(niveau.get());
                return new ResponseEntity<>("{\"message\":\""+"Niveau bien Modifie"+"\"}",HttpStatus.OK);
            }
            
        } catch (Exception e) {
            e.printStackTrace();

        }
        throw new UnsupportedOperationException("Unimplemented method 'updateNive'");
    }
    @SuppressWarnings("null")
    @Override
    public ResponseEntity<String> supprimerNiveau(Long id) {
        // TODO Auto-generated method stub
        try {
            niveauRes.deleteById(id);
            return new ResponseEntity<>("{\"message\":\""+"Ce niveau a été supprimé"+"\"}",HttpStatus.OK);   
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return new ResponseEntity<>("{\"message\":\""+"Erreur de suppression"+"\"}",HttpStatus.INTERNAL_SERVER_ERROR);   

    }
    @SuppressWarnings({ "null"})
    @Override
    public ResponseEntity<Niveau> getByid(Long id) {
        // TODO Auto-generated method stub
        try {

            System.out.println(niveauRes.findNiveau(id));

            return new ResponseEntity<Niveau>(niveauRes.findNiveau(id),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
