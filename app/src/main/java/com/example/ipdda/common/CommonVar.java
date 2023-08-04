package com.example.ipdda.common;

import com.example.ipdda.member.MemberVO;

public class CommonVar {
    // 안드로이드는 스프링과 다름. ( Session이 없음 )
    // static변수를 활용.

    public static MemberVO loginInfo; // 여기에 로그인이 정상적으로 되면 저장됨.
}
