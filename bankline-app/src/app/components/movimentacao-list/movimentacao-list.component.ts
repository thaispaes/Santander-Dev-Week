import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-movimentacao-list',
  templateUrl: './movimentacao-list.component.html',
  styleUrls: ['./movimentacao-list.component.css']
})
export class MovimentacaoListComponent implements OnInit {
  movimentacoes:any;

  constructor() { }

  ngOnInit(): void {
  }

}
