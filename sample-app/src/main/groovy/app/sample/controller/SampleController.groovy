package app.sample.controller

import app.sample.config.CommonConfig
import app.sample.config.SampleConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
@RequestMapping(value = '/test', produces = 'application/json')
class SampleController {

    @Autowired SampleConfig sampleConfig
    @Autowired CommonConfig commonConfig
    @Autowired MessageSource messageSource

    @RequestMapping(method = GET)
    def test() {
        [
            'sample.name': sampleConfig.name,
            'common.companyName': commonConfig.companyName,
            'message': messageSource.getMessage('my.message', null, Locale.ENGLISH)
        ]
    }
}
