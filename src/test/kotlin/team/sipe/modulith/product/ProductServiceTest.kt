package team.sipe.modulith.product

import org.junit.jupiter.api.Test
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter
import team.sipe.modulith.SpringModulithPocApplication
import java.util.function.Consumer

class ProductServiceTest {

    /**
     * 이 테스트는 모듈 구조를 생성하는 데 사용됩니다.
     */
    @Test
    fun createApplicationModuleModel() {
        val modules = ApplicationModules.of(SpringModulithPocApplication::class.java)

        modules.forEach(Consumer(::println))
    }

    /**
     * 이 테스트는 모듈 구조를 검증하는 데 사용됩니다.
     */
    @Test
    fun verifiesModularStructure() {
        val modules = ApplicationModules.of(SpringModulithPocApplication::class.java)

        modules.verify()
    }

    /**
     * 이 테스트는 모듈 문서를 생성하는 데 사용됩니다.(Asciidoctor, PlantUML)
     */
    @Test
    fun createModuleDocumentation() {
        val modules = ApplicationModules.of(SpringModulithPocApplication::class.java)
        Documenter(modules)
            .writeDocumentation()
            .writeIndividualModulesAsPlantUml()
    }
}
