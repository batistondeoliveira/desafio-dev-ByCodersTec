import { Http } from '../config/Https';

class CnabService {
  static async send(data) {
    return Http.post('cnab', data);        
  }
}

export default CnabService;