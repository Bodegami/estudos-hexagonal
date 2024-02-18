package com.bodegami.hexagonal.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.bodegami.hexagonal")
public class NamingConventionTest {

    //Verificando se as classes estão nos diretorios corretos
    @ArchTest
    public static final ArchRule consumer_reside_only_consumer_package = classes()
            .that()
            .haveNameMatching(".*Consumer") //Sufixo a ser verificado
            .should()
            .resideInAPackage("..adapters.input.consumer") //diretorio onde deve residir as classes
            .as("Consumer classes reside inside consumer package in adapters.input package"); //msg erro personalizada

    @ArchTest
    public static final ArchRule mapper_reside_only_mapper_package = classes()
            .that()
            .haveNameMatching(".*Mapper")
            .should()
            .resideInAnyPackage("..adapters.input.consumer.mapper", "..adapters.input.controller.mapper",
                    "..adapters.output.client.mapper", "..adapters.output.repository.mapper")
            .as("Mapper classes should reside inside mapper package in controller, client, consumer and repository packages");

    @ArchTest
    public static final ArchRule message_reside_only_message_package = classes()
            .that()
            .haveNameMatching(".*Message")
            .should()
            .resideInAPackage("..adapters.input.consumer.message")
            .as("Message classes should reside inside message package in adapters.input.consumer.message package");

    @ArchTest
    public static final ArchRule controller_reside_only_controller_package = classes()
            .that()
            .haveNameMatching(".*Controller")
            .should()
            .resideInAPackage("..adapters.input.controller")
            .as("Controller classes should reside inside controller package in adapters.input.controller package");

    @ArchTest
    public static final ArchRule should_be_suffixed_consumer = classes()
            .that()
            .resideInAPackage("..consumer")
            .should()
            .haveSimpleNameEndingWith("Consumer");

    @ArchTest
    public static final ArchRule should_be_suffixed_adapter = classes()
            .that()
            .resideInAPackage("..adapters.output")
            .should()
            .haveSimpleNameEndingWith("Adapter");

    @ArchTest
    public static final ArchRule should_be_suffixed_mapper = classes()
            .that()
            .resideInAPackage("..mapper")
            .should()
            .haveSimpleNameEndingWith("Mapper")
            .orShould()
            .haveSimpleNameEndingWith("MapperImpl"); //O mapper gera a implementacao, nesse caso precisamos indica-la tb nos testes


}
