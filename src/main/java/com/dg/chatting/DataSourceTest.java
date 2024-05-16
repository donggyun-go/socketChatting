package com.dg.chatting;

import java.sql.Connection;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.dg.chatting.config.DataSourceConfig;
import com.dg.chatting.config.MybatisConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DataSourceConfig.class, MybatisConfig.class})
public class DataSourceTest {

    @Autowired
    private DataSource ds;

    @Test
    public void testConnection() throws Exception {
        try (Connection con = ds.getConnection()) {
            System.out.println(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}