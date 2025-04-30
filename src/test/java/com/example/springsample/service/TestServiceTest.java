package com.example.springsample.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.springsample.mapper.TestMapper;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class TestServiceTest {

    @Mock
    private TestMapper testMapper;

    @InjectMocks
    private TestService testService;

    @Test
    public void testSelectOne() {
        // テストデータの準備
        int expected = 1;
        
        // Mapperのモック設定
        when(testMapper.selectOne()).thenReturn(expected);

        // テスト実行
        int actual = testService.selectOne();

        // 検証
        assertThat(actual).isEqualTo(expected);
        verify(testMapper).selectOne();
    }
} 