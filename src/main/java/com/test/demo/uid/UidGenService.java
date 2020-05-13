package com.test.demo.uid;


import com.baidu.fsg.uid.UidGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: uidgeneratortest
 * @description:
 * @author: X-Pacific zhang
 * @create: 2019-10-13 17:28
 **/
@Service
public class UidGenService {
    @Resource
    private UidGenerator uidGenerator;

    public long getUid() {
        return uidGenerator.getUID();
    }
}
