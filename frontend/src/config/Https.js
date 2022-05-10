import Axios from 'axios';
import { apiUrl } from './App';

export const Http = Axios.create({
    baseURL: apiUrl
});