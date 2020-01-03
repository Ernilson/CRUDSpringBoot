

import br.com.CrudSpringBoot.Model.CadModel;
import br.com.CrudSpringBoot.ServiceImpl.CadServiceImpl;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class CrudSpringBootApplicationTests {

     private CadServiceImpl service;
     
    @Autowired
    public CrudSpringBootApplicationTests(CadServiceImpl service) {
        this.service = service;
    }    
        
	@Test
	void contextLoads() {
        CadModel cm = new CadModel();
        cm.setNome("Sibre");
        cm.setEnder("Hoje");
        cm.setFone("1234567");
        cm.setEmail("@Sibre");   
        
        service.saveOrUpdate(cm);
	}

}
