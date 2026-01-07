package eu.padroes_de_projeto.dto;

import jakarta.validation.constraints.NotBlank;

public class ClientRequestDTO {
    @NotBlank
    private String name;
    private AddressRequestDTO address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressRequestDTO getAddress() {
        return address;
    }

    public void setAddress(AddressRequestDTO address) {
        this.address = address;
    }
}
