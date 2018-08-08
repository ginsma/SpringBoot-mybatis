    package com.gin;

    import com.gin.domain.Girl;
    import com.gin.service.GirlService;
    import org.junit.Assert;
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.test.context.junit4.SpringRunner;

    /**
     * Created by Jean .
     * 2018/8/3
     */
    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class GirlServiceTest {

        @Autowired
        private GirlService girlService;

        @Test
        public void findoneTest() {
            Girl girl = girlService.findOne(2);
            Assert.assertEquals(new Integer(16),girl.getAge());
        }
    }
