package com.dong.vote.demo.service;

import com.dong.vote.demo.base.ConfigDO;
import com.dong.vote.demo.dto.ConfigDTO;
import com.dong.vote.demo.repository.AbstractBaseRepository;
import com.dong.vote.demo.repository.AbstractConfigRepository;
import com.dong.vote.demo.result.ServerResponse;
//import com.github.benmanes.caffeine.cache.Caffeine;
//import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.spring.RedisCache;
import org.springframework.beans.BeansException;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author: dongxiaohua
 * @date: 2022-09-18 14:47:38
 */
public abstract class AbstractBaseService<DO extends ConfigDO, DTO extends ConfigDTO> implements IBaseService<DTO>, ApplicationContextAware {

  protected final AbstractBaseRepository<DO> repository;
  protected final String type;

  protected Class<DO> doClass;
  protected Class<DTO> dtoClass;

  protected RedisCache redisCache;
  private final BeanCopier do2dtoCopier;
  private final BeanCopier dto2doCopier;
  protected ApplicationContext context;
//  protected LoadingCache<String, Optional<DTO>> isGrayCache;


  public AbstractBaseService(AbstractConfigRepository<DO> repository, String type) {
    this.repository = repository;
    initClass();

    do2dtoCopier = BeanCopier.create(this.doClass, this.dtoClass, false);
    dto2doCopier = BeanCopier.create(this.dtoClass, this.doClass, false);
    this.type = type;
//    this.isGrayCache = Caffeine.newBuilder().expireAfterWrite(5, TimeUnit.SECONDS).maximumSize(128).build(this::cacheLoad);
  }

  private void initClass() {
    try {
      final ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
      final Type[] actualTypeArguments = type.getActualTypeArguments();
      this.doClass = (Class<DO>) Class.forName(actualTypeArguments[0].getTypeName());
      this.dtoClass = (Class<DTO>) Class.forName(actualTypeArguments[1].getTypeName());
    } catch (ClassNotFoundException ignore) {
      // 通过反射找到的类一定存在，忽略改异常
    }
  }


  @Override
  public ServerResponse<DTO> execute(DTO dto) {
    return null;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

  }

  /**
   * 缓存Optional来识别null
   *
   * @param key
   * @return
   */
  public Optional<DTO> cacheLoad(String key) {
    try {
      return Optional.of(dtoClass.newInstance());
    } catch (Exception e) {
      return Optional.empty();
    }
  }
}
