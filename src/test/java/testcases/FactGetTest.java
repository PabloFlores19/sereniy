package testcases;

import com.serenity.project.dataprovider.ApiGet;
import com.serenity.project.facts.SpotifyPlans;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class FactGetTest {

    @Test
    public void factTest(){

        ApiGet path = new ApiGet();
        Actor pablo = Actor.named("test fact")
                .whoCan(CallAnApi.at(path.getApi()));

        pablo.has(SpotifyPlans.toListerMusic());
    }
}
