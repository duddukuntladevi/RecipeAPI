package com.recipe.model.domain.request;

import com.recipe.config.ValidationConfig;
import com.recipe.model.entity.RecipeType;
import com.recipe.validator.EnumValidator;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;
import java.util.List;

public class CreateRecipeRequest {
    @NotBlank(message = "{recipe.name.not.blank}")
    @Size(max = ValidationConfig.MAX_LENGTH_NAME, message = "{recipe.name.size}")
    @Pattern(regexp = ValidationConfig.PATTERN_NAME, message = "{recipe.name.pattern}")
    @ApiModelProperty(notes = "The name of the recipe", example = "Pasta")
    private String name;

    @ApiModelProperty(notes = "The type of the recipe", example = "VEGETARIAN")
    @EnumValidator(enumClass = RecipeType.class, message = "{recipe.type.invalid}")
    private String type;

    @NotNull(message = "{number.of.servings.not.null}")
    @Positive(message = "{number.of.servings.positive}")
    @ApiModelProperty(notes = "The number of servings per recipe", example = "4")
    private int numberOfServings;

    @ApiModelProperty(notes = "The ids of the ingredients needed to make the recipe", example = "[1,2]")
    private List<Integer> ingredientIds;

    @NotBlank(message = "{instructions.not.blank}")
    @Size(max = ValidationConfig.MAX_LENGTH_DEFAULT, message = "{instructions.size}")
    @Pattern(regexp = ValidationConfig.PATTERN_FREE_TEXT, message = "{instructions.pattern}")
    @ApiModelProperty(notes = "The instructions to create the recipe", example = "Chop the tomato, stir and fry, boil and serve")
    private String instructions;

    public CreateRecipeRequest() {
    }

    public CreateRecipeRequest(String name, String type, int numberOfServings, List<Integer> ingredientIds, String instructions) {
        this.name = name;
        this.type = type;
        this.numberOfServings = numberOfServings;
        this.ingredientIds = ingredientIds;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfServings() {
        return numberOfServings;
    }

    public void setNumberOfServings(int numberOfServings) {
        this.numberOfServings = numberOfServings;
    }

    public List<Integer> getIngredientIds() {
        return ingredientIds;
    }

    public void setIngredientIds(List<Integer> ingredientIds) {
        this.ingredientIds = ingredientIds;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
