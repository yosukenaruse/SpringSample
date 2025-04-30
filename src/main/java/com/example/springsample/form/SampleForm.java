package com.example.springsample.form;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SampleForm {
    @NotNull(message = "IDは必須です")
    private Integer id;

    @NotNull(message = "名前は必須です")
    @Pattern(regexp = "^[A-Z]+$", message = "名前は大文字アルファベットのみ使用可能です")
    private String name;
} 