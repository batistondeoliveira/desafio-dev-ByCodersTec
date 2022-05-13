import { Http } from '../config/Https';

class RelatorioService {    
  static async get() {
    return Http.get('relatorio');
  }
}

export default RelatorioService;
