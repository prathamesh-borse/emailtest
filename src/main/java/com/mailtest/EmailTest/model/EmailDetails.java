package com.mailtest.EmailTest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {

    private String repositoryUrl;
    private String prUrl;
    private List<String> contributors;

}
