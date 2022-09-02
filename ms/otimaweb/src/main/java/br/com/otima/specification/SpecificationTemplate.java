package br.com.otima.specification;

import br.com.otima.entity.PosteEntity;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationTemplate {

    @And({
            @Spec(path = "bairro", spec = Equal.class),
            @Spec(path = "identificacao", spec = Like.class)
    })
    public interface PosteSpec extends Specification<PosteEntity> {}
}
