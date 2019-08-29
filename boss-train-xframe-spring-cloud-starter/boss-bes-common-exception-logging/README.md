#异常信息捕获步骤：
    service层：
        在捕获到异常之后抛出ServiceException，由控制层处理该异常
            public int update(ExamPublishRecordDTO examPublishRecordDTO) {
                if (!StringUtils.isEmpty(examPublishRecordDTO)) {
                    throw new ServiceException(ExamExceptionEnum.PUBLISH_EXAM_VERSION_DISACORD);
                }
                return 0;
            }
            
    controller层：
        在Service层捕获到异常并返回之后处理异常，大概流程为：
                int result = 0;
                try {
                    result = examPublishRecordService.update(examPublishRecordDTO);
                }catch (ServiceException e){
                    throw new BusinessException(e);
                 }
        
        并且在方法上加上注解
         @GlobalExceptionLog
    
    前端接受异常信息为：
            
            updatePublishRecord(this.editFormData)
                    .then(resp => {
                      console.log(resp);
                      if (resp.responseHead.code == "0") {
                        this.$message({
                          message: resp.responseHead.message.toString(),
                          type: "success"
                        });
                        return;
                        alert(resp.responseHead.message.toString());
                      } else {
                        alert(
                          "错误码：" +
                            resp.responseHead.code +
                            ";错误信息：" +
                            resp.responseHead.message
                        );
                      }
                    })
                    .catch(err => {
                      this.$message({
                        showClose: true,
                        message: "系统异常",
                        type: "error"
                      });
                    });
                    
            updatePublishRecord为自己封装的API，code为0则服务处理正常，不为0则为异常，输出异常码和异常信息