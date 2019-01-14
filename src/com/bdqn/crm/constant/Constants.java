package com.bdqn.crm.constant;


/**
 * 系统常量
 */
public class Constants {

    public interface Sex{
        int MAN = 0;            // 男
        int WOMAN = 1;          // 女
    }

    public interface Role{
        int ADMIN = 0;          // 管理员
        int BASE_UESR = 1;      // 普通用户
    }

    public interface Nation{
        int NATION_00 = 0;  // 汉族
        int NATION_01 = 1;
        int NATION_02 = 2;
    }

    public interface Married{
        int MARRIED = 0;        // 已婚
        int UNMARRIED = 1;      // 未婚
    }

    public interface Diploma{
        int EDU_00 = 0;         // 小学
        int EDU_01 = 1;         // 初中
        int EDU_02 = 2;         // 高中
        int EDU_03 = 3;         // 专科
        int EDU_04 = 4;         // 本科
        int EDU_05 = 5;         // 硕士
        int EDU_06 = 6;         // 博士
    }

    public interface State{
        int ENABLE = 0;         // 激活
        int DISABLE = 1;        // 未激活
    }


}
