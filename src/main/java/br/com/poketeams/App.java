package br.com.poketeams;

import br.com.poketeams.model.task.SetupTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.poketeams")
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);

        SetupTask runBean = run.getBean(SetupTask.class);
        runBean.loadCreatures();
        runBean.loadMoves();
    }
}
