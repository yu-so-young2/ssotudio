package com.soyoung.ssotudio.ssotudio.dto.button;

import com.soyoung.ssotudio.ssotudio.dto.ContentType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ColoredButton extends Button {
    private String color;

    @Builder(builderMethodName = "coloredButtonBuilder")
    public ColoredButton(ContentType type, String value, String variant, TargetContainer targetContainer, String color) {
        super(type, value, variant, targetContainer);
        this.color = color;
    }
}