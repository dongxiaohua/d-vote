package com.dong.vote.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by dongxiaohua on 2017/12/1.
 */
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vote {
  private int id;
  private String vName;
  private String vNum;
  private String vOption;

}
